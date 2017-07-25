package com.asela.monad;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class OptionalTest {
    
    public static Optional<Person> createPerson(FieldProvider<String> fieldProvider) {
        return fieldProvider.getField().flatMap(name ->
            fieldProvider.getField().flatMap(line1 ->
            fieldProvider.getField().flatMap(line2 ->
            fieldProvider.getField().flatMap(cityName ->
            fieldProvider.getField().flatMap(cityCode ->
            Optional.of(new Person(name, new Address(line1, line2, new City(cityName, cityCode))))   
        )))));
    }
    
    public static void print(Person person) {
        person.getName().map(name -> "N: " + name +
            person.getAddress().map(address -> ", address -> " + 
            address.getLine1().map(line1 -> "L1: " + line1 +
            address.getLine2().map(line2 -> ", L2: " + line2 + 
            address.getCity().map(city -> ", city -> " +
            city.getName().map(cityName -> " CN: " + cityName +
            city.getCode().map(cityCode -> ", CC: " +   cityCode + ""
        ).orElse(" <NULL>")).orElse(" <NULL>")).orElse(" <NULL>")).orElse(" <NULL>")).orElse(" <NULL>")).orElse(" <NULL>"))
        .ifPresent(System.out::println);;
    }

    @Test
    public void testSomeWiredStuff() {
        Map<String, Person> people = new HashMap<>();
        Person person1 = createPerson(FieldProvider.get("Nil", "AA")).get();
        people.put(person1.getName().get(), person1);
        print(person1);

        Optional.of(people.get("AA"))
            .flatMap(Person::getAddress)
            .flatMap(Address::getCity)
            .flatMap(City::getCode)
            .ifPresent(System.out::println);
        
        Person person2 = new Person("BB", null);
        people.put(person2.getName().get(), person2);
        print(person2);
        
        Optional.of(people.get("BB"))
        .flatMap(Person::getAddress)
        .flatMap(Address::getCity)
        .flatMap(City::getCode)
        .ifPresent(System.out::println);
    }
    
    @Test
    public void testName() throws Exception {
        
        assertThat("AB", is(concat(Optional.of("A"), Optional.of("B")).get()));
        assertFalse(concat(Optional.empty(), Optional.of("B")).isPresent());
        assertFalse(concat(Optional.of("A"), Optional.empty()).isPresent());
        assertFalse(concat(Optional.empty(), Optional.empty()).isPresent());
    }
    
    public Optional<String> concat(Optional<String> one, Optional<String> two) {
        return one.flatMap(o -> 
               two.flatMap(t -> 
               Optional.of(o.concat(t))
        ));
    }

}

class Person {
    private String name;
    private Address Address;
    
    public Person(String name, Address address) {
        super();
        this.name = name;
        Address = address;
    }
    
    public Optional<String> getName() {
        return Optional.of(name);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Optional<Address> getAddress() {
        return Optional.ofNullable(Address);
    }
    
    public void setAddress(Address address) {
        Address = address;
    }
}

class Address {
    private String line1;
    private String line2;
    private City city;
          
    
    public Address(String line1, String line2, City city) {
        super();
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
    }
    public Optional<String> getLine1() {
        return Optional.of(line1);
    }
    public void setLine1(String line1) {
        this.line1 = line1;
    }
    public Optional<String> getLine2() {
        return Optional.of(line2);
    }
    public void setLine2(String line2) {
        this.line2 = line2;
    }
    public Optional<City> getCity() {
        return Optional.ofNullable(city);
    }
    public void setCity(City city) {
        this.city = city;
    }
}

class City {
    private String name;
    private String code;

    public City(String name, String code) {
        super();
        this.name = name;
        this.code = code;
    }
    public Optional<String> getName() {
        return Optional.of(name);
    }
    public void setName(String name) {
        this.name = name;
    }
    public Optional<String> getCode() {
        return Optional.of(code);
    }
    public void setCode(String code) {
        this.code = code;
    }
}

class FieldProvider<T> {
    private List<T> list = new LinkedList<>();
    private int index = 0;
    private T defaultValue;
    public Optional<T> getField() {
        if(index >= list.size()) return Optional.ofNullable(defaultValue);
        return Optional.ofNullable(list.get(index++));
    }
    
    public static <T> FieldProvider<T> get(T d, T...t) {
        FieldProvider<T> fieldProvider = new FieldProvider<>();
        Stream.of(t).forEach(fieldProvider.list::add);
        fieldProvider.defaultValue = d;
        return fieldProvider;
    }
}

package com.clean.coders.dijkstras;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class ShortestPathTest {

    @Test
    public void nothing() throws Exception {

    }

    @Test
    public void degenerateCases() throws Exception {
        assertMinPath("", 0, "[]");// empty graph
        assertMinPath("A", 0, "[]");// on node
        assertMinPath("B1C", 0, "[]");// no start or end
        assertMinPath("A1C", 0, "[]");// no end
        assertMinPath("B1Z", 0, "[]");// no start
    }

    @Test
    public void oneEdge() throws Exception {
        assertMinPath("A1Z", 1, "[A, Z]");
        assertMinPath("A2Z", 2, "[A, Z]");

    }

    @Test
    public void twoEdge() throws Exception {
        assertMinPath("A1B,B1Z", 2, "[A, B, Z]");
        assertMinPath("B1Z,A1B", 2, "[A, B, Z]");
        assertMinPath("A1X,Y1Z", 0, "[]");
    }

    @Test
    public void threeEdges() throws Exception {
        assertMinPath("A2B,B3C,C4Z", 9, "[A, B, C, Z]");
        assertMinPath("B3C,C4Z,A2B", 9, "[A, B, C, Z]");
    }

    @Test
    public void onlyOnePath() throws Exception {
        assertMinPath("A1B,B2C,C3Z,B4D,D6E", 6, "[A, B, C, Z]");
        assertMinPath("A1B,B2C,C3D,C3Z", 6, "[A, B, C, Z]");
    }

    private void assertMinPath(String graph, Integer length, String path) {
        PathFinder pf = makePathFinder(graph);

        if (length != null)
            assertThat(pf.getLength(), is(length));
        if (path != null)
            assertThat(pf.minPath().toString(), is(path));
    }

    private PathFinder makePathFinder(String graph) {
        PathFinder pf = new PathFinder();
        Pattern edgePattern = Pattern.compile("(\\D+)(\\d+)(\\D+)");
        String[] edges = graph.split(",");
        for (String edge : edges) {

            Matcher matcher = edgePattern.matcher(edge);
            if (matcher.matches()) {

                String start = matcher.group(1);
                String end = matcher.group(3);
                int length = Integer.parseInt(matcher.group(2));
                pf.addEdget(start, end, length);
            }
        }
        pf.findPath("A", "Z");
        return pf;
    }

}

class PathFinder {

    private List<Edge>   edges  = new ArrayList<>();
    private List<String> path   = new ArrayList<>();
    private int          length = 0;

    public static class Edge {
        public String begin;
        public String end;
        public int    length;

        public Edge(String begin, String end, int length) {
            this.begin = begin;
            this.end = end;
            this.length = length;
        }
    }

    public void addEdget(String start, String end, int length) {
        edges.add(new Edge(start, end, length));
    }

    public void findPath(String begin, String end) {
        List<String> p = new ArrayList<>();
        int l = 0;
        p.add(begin);
        for (Edge e = findEdge(begin); e != null; e = findEdge(e.end)) {
            p.add(e.end);
            l += e.length;
            if (e.end.equals(end)) {
                length = l;
                path = p;
                return;
            }
        }
    }

    private Edge findEdge(String edgeBegin) {
        return edges.stream().filter(e -> e.begin.equals(edgeBegin)).findFirst().orElse(null);
    }

    public List<String> minPath() {
        return path;
    }

    public int getLength() {
        return length;
    }

}
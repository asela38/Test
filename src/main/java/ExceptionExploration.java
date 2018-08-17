import org.junit.Test;

public class ExceptionExploration {

    private void method2() throws Exception {
        Exception exception = new Exception();
        throw exception;
    }

    private void methodWrapException() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test
    public void testWrapExceptionPropagation() throws Exception {
        try {
            methodWrapException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void methodRethrowException() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            throw e;
        }
    }

    @Test
    public void testRethrowExceptionPropagation() throws Exception {
        try {
            methodRethrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

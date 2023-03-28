public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
    //"Element with id: " + id + " not found"
}

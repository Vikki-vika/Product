public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Element with id: " + id + " not found");
    }
}
/*public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
   }*/



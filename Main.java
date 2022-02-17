/**
 * Lab 06 - Event Handling and MVC Apporach
 * Testing 01
 */

public class Main {
    public static void main(String[] args) {

        /**Create a View instance as view */
        View view = new View();

        /**Create a Model instance as model */
        Model model = new Model(view) ;

        /**Create a Controller instance */
        new Controller(model, view);
    }
}

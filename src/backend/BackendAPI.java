package backend;

public interface BackendAPI {


    /**
     * interprets all of the code
     * TODO: change void to returning a list of commands for front end to execute
     *
     * @param code
     */
    public void interpret(String code);

    public void setLanguage(String language);

    public void forward(double val);

    public void backward(double val);

    public void left

}

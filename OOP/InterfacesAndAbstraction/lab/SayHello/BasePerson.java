package InterfacesAndAbstraction.lab.SayHello;

public abstract class BasePerson implements Person {

    private String name;

    public BasePerson(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello!";
    }
}

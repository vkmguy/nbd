import com.basho.riak.client.api.commands.kv.UpdateValue;

public class ComputerUpdate extends UpdateValue.Update<Computer> {
    private final Computer update;

    public ComputerUpdate(Computer update) {
        this.update = update;
    }

    @Override
    public Computer apply(Computer computer) {
        if (computer == null) {
            computer = new Computer();
        }
        computer.name = update.name;
        computer.price = update.price;
        computer.quantity = update.quantity;
        computer.type = update.type;
        return computer;
    }
}
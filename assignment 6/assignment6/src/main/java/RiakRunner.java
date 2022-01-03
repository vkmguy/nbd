import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.api.commands.kv.UpdateValue;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;

import java.util.concurrent.ExecutionException;

public class RiakRunner {
    public static void main(String[] args) {
        try {
            RiakClient client = RiakClient.newClient("8098", "localhost");
            Namespace computerBucket = new Namespace("s23686");
            Location computerLocation = new Location(computerBucket, "hpComputer");

            Computer computer = new Computer();

            computer.name = "HP";
            computer.type = "PC";
            computer.quantity = 10;
            computer.price = 1234;

            StoreValue storeValue = new StoreValue.Builder(computer)
                    .withLocation(computerLocation)
                    .build();
            client.execute(storeValue);
            System.out.println("computer Successfully created in bucket");

            printComputer(client, computerLocation);

            computer.quantity = 15;
            ComputerUpdate computerUpdate = new ComputerUpdate(computer);
            UpdateValue updateValue = new UpdateValue.Builder(computerLocation)
                    .withUpdate(computerUpdate).build();
            client.execute(updateValue);
            System.out.println("Computer successfully updated");

            printComputer(client, computerLocation);

            DeleteValue deleteValue = new DeleteValue.Builder(computerLocation)
                    .build();
            client.execute(deleteValue);
            System.out.println("Computer successfully deleted");

            printComputer(client, computerLocation);

            client.shutdown();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printComputer(RiakClient client, Location location) throws ExecutionException, InterruptedException {
        FetchValue fetchValue = new FetchValue.Builder(location)
                .build();
        Computer computer = client.execute(fetchValue).getValue(Computer.class);
        if (computer != null) {
            System.out.println(computer);
            System.out.println("computer object fetched successfully!");
        } else {
            System.out.println("Computer object not present !!");
        }
    }
}

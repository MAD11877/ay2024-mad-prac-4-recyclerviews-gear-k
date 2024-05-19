package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private ArrayList<User> userList;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userList = generateRandomUsers(20);
        userAdapter = new UserAdapter(userList, this);
        recyclerView.setAdapter(userAdapter);
    }

    private ArrayList<User> generateRandomUsers(int count) {
        ArrayList<User> users = new ArrayList<>();
        Random random = new Random();
        String[] names = {"John", "Jane", "Alex", "Chris", "Katie", "Laura", "Mike", "David", "Anna", "Tom"};
        String[] descriptions = {"Lorem ipsum", "Dolor sit amet", "Consectetur adipiscing", "Elit", "Sed do eiusmod"};

        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)] + random.nextInt(1000); // Randomize names
            String description = descriptions[random.nextInt(descriptions.length)];
            boolean followed = random.nextBoolean();
            users.add(new User(name, description, i, followed));
        }
        return users;
    }
}

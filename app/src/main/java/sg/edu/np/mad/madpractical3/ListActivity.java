package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
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

        // Set up the ImageView with AlertDialog
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile")
                        .setMessage("MADness")
                        .setPositiveButton("VIEW", (dialog, which) -> {
                            // Generate a random integer
                            Random random = new Random();
                            int randomInt = random.nextInt(100); // Generates a random integer from 0 to 99

                            // Create an Intent to start MainActivity
                            Intent intent = new Intent(ListActivity.this, MainActivity.class);
                            intent.putExtra("RandomNumber", randomInt);
                            startActivity(intent);
                        })
                        .setNegativeButton("CLOSE", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        // Create a list of 20 random users
        userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            userList.add(new User(generateRandomName(), generateRandomDescription(), i, new Random().nextBoolean()));
        }

        // Set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }

    private String generateRandomName() {
        String[] names = {"John", "Jane", "Alex", "Chris", "Katie", "Laura", "Mike", "David", "Anna", "Tom"};
        return names[new Random().nextInt(names.length)];
    }

    private String generateRandomDescription() {
        String[] descriptions = {"Lorem ipsum", "Dolor sit amet", "Consectetur adipiscing", "Elit", "Sed do eiusmod"};
        return descriptions[new Random().nextInt(descriptions.length)];
    }
}

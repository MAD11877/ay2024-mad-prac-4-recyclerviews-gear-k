package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnMessage = findViewById(R.id.btnMessage); // Make sure the ID matches the one in your XML
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MessageGroup Activity
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });

        // Retrieve the random integer from the Intent
        int randomInt = getIntent().getIntExtra("RandomNumber", 0); // Default to 0 if no data found

        // Creating a user instance
        User user = new User("John Doe", "MAD Developer", 1, false);

        // Getting references to the UI components
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check current text of the button
                if (btnFollow.getText().toString().equalsIgnoreCase("FOLLOW")) {
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                    btnFollow.setText("UNFOLLOW");
                } else {
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                    btnFollow.setText("FOLLOW");
                }
            }
        });

        // Set the TextViews with the User's name and random integer
        tvName.setText(user.name + " " + randomInt); // Display name and random integer
        tvDescription.setText(user.description);
        btnFollow.setText("FOLLOW");  // Set the initial button text as "FOLLOW"

    }
}

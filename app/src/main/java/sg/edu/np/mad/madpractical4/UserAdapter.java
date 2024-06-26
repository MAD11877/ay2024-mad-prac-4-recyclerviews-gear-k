package sg.edu.np.mad.madpractical4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<User> userList;
    private Context context;

    // Constructor used in tests
    public UserAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    // Constructor used in the actual app
    public UserAdapter(ArrayList<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.nameTextView.setText(user.name);
        holder.descriptionTextView.setText(user.description);
        holder.smallImageView.setImageResource(R.drawable.ic_launcher_foreground);

        if (user.name.endsWith("7")) {
            holder.additionalImageView.setVisibility(View.VISIBLE);
        } else {
            holder.additionalImageView.setVisibility(View.GONE);
        }

        holder.smallImageView.setOnClickListener(v -> {
            // Show an AlertDialog with the user's name
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Profile")
                    .setMessage(user.name)
                    .setPositiveButton("VIEW", (dialog, which) -> {
                        // Generate a random integer and start MainActivity
                        Random random = new Random();
                        int randomInt = random.nextInt(100); // Generates a random integer from 0 to 99

                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        intent.putExtra("RandomNumber", randomInt);
                        v.getContext().startActivity(intent);
                    })
                    .setNegativeButton("CLOSE", (dialog, which) -> dialog.dismiss())
                    .setCancelable(true);
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

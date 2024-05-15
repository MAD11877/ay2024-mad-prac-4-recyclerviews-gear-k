package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sg.edu.np.mad.madpractical3.R;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTextView;
    public TextView descriptionTextView;
    public ImageView smallImageView;
    public ImageView largeImageView;
    public ImageView additionalImageView;
    public ToggleButton followToggleButton;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        smallImageView = itemView.findViewById(R.id.smallImageView);
        largeImageView = itemView.findViewById(R.id.largeImageView);
        additionalImageView = itemView.findViewById(R.id.additionalImageView);
        followToggleButton = itemView.findViewById(R.id.followToggleButton);
    }
}

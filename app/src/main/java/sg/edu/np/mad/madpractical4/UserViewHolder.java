package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTextView;
    public TextView descriptionTextView;
    public ImageView smallImageView;
    public ImageView additionalImageView;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        smallImageView = itemView.findViewById(R.id.smallImageView);
        additionalImageView = itemView.findViewById(R.id.additionalImageView);
    }
}

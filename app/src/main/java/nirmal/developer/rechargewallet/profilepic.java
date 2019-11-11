package nirmal.developer.rechargewallet;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profilepic extends AppCompatActivity {
    TextView textView;
    ImageView img;
    Button pro,upl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView=findViewById(R.id.textView);
        img=findViewById(R.id.imageView);
        pro=findViewById(R.id.propic);
        upl=findViewById(R.id.upload);

    }
}
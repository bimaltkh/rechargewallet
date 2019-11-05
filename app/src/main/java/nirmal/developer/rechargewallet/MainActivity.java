package nirmal.developer.rechargewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,DOB,usrname,pass,conpass;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        DOB=findViewById(R.id.dob);
        usrname=findViewById(R.id.userID);
        pass=findViewById(R.id.pass);
        conpass=findViewById(R.id.conpass);
        button=findViewById(R.id.reg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() && DOB.getText().toString().isEmpty() && usrname.getText().toString().isEmpty() && pass.getText().toString().isEmpty() || conpass.getText().toString().equals(pass)) {
                    Toast.makeText(MainActivity.this, "field is empty", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}

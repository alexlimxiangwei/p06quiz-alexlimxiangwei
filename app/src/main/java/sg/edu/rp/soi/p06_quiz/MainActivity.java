package sg.edu.rp.soi.p06_quiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    TextView tvOperation;
    TextView tvResult;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.etNum1);
        et2 = findViewById(R.id.etNum2);

        tvResult = findViewById(R.id.tvResult);
        tvOperation = findViewById(R.id.tvOperation);
        btnReset = findViewById(R.id.btnReset);

        registerForContextMenu(tvOperation);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                tvResult.setText("");
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"+");
        menu.add(0,1,1,"-");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        int num1 = Integer.valueOf(et1.getText().toString());
        int num2 = Integer.valueOf(et2.getText().toString());
        int res = 0;
        if (id == 0) {
            res = num1 + num2;
        } else if (id == 1) {
            res = num1 - num2;
        }
        tvResult.setText(res + "");
        return true;
    }




}

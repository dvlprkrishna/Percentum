package in.dvlpr.percentum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText oldPriceEdit, discountEdit;
    Button btn_calculate;
    TextView newPriceEdit, finalPriceEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oldPriceEdit = (EditText) findViewById(R.id.Placeholder_billAmt);
        discountEdit = (EditText) findViewById(R.id.Placeholder_discount);
        // btn_calculate = (Button) findViewById(R.id.btn_calc);
        newPriceEdit = (TextView) findViewById(R.id.placeholder_amtPaid);
        finalPriceEdit = (TextView) findViewById(R.id.placeholder_amtSaved);

        Button btn = (Button) findViewById(R.id.btn_calc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n = Double.parseDouble(oldPriceEdit.getText().toString());
                double p = Double.parseDouble(discountEdit.getText().toString());

               // String message = getString(R.string.Placeholder_Rupee);

                double x = (p*n)/100;
                double FinalPrice = n - x;
                String newMsg = String.format(Locale.US, "Rs. %.2f", x);
                String finalMsg = String.format(Locale.US, "Rs. %.2f", FinalPrice);
                finalPriceEdit.setText(newMsg);
                newPriceEdit.setText(finalMsg);
            }
        });
    }
}

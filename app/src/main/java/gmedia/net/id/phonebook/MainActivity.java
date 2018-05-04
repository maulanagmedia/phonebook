package gmedia.net.id.phonebook;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText edtNama;
    private EditText edtAlamat;
    private EditText edtNomor, edtDate;
    private ImageButton ibDate;
    private RadioGroup rgJenisKelamin;
    private RadioButton rbLaki, rbPerempuan;
    private Spinner spnJenis;
    private Button btnSimpan;
    private final String formatDate = "yyyy-MM-dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {

        edtNama = (EditText) findViewById(R.id.edtNama);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtNomor = (EditText) findViewById(R.id.edtNomor);
        edtDate = (EditText) findViewById(R.id.edtDate);
        ibDate = (ImageButton) findViewById(R.id.ibDate);
        rgJenisKelamin = (RadioGroup) findViewById(R.id.rgJenisKelamin);
        rbLaki = (RadioButton) findViewById(R.id.rbLaki);
        rbPerempuan = (RadioButton) findViewById(R.id.rbPerempuan);
        spnJenis = (Spinner) findViewById(R.id.spnJenis);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        initEvent();
    }

    private void initEvent() {

        ibDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar calendar;
                calendar = Calendar.getInstance();
                final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DATE, date);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate, Locale.US);
                        edtDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };

                new DatePickerDialog(MainActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)).show();
            }
        });
    }

}

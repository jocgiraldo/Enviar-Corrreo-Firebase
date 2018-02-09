package co.hitcompany.enviarcorreofirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtSubject;
    EditText edtMessage;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSubject = (EditText) findViewById(R.id.edtSubject);
        edtMessage = (EditText) findViewById(R.id.edtMessage);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void onBtnSend(View v){
        if (setValidar()){
            DatabaseReference dbrCorreo = databaseReference.child("CORREO");
            Correo correo = new Correo();
            correo.setCorreo(edtEmail.getText().toString());
            correo.setAsunto(edtSubject.getText().toString());
            correo.setMensaje(edtMessage.getText().toString());
            dbrCorreo.push().setValue(correo, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError.getMessage()!=null){

                    }else{
                        edtEmail.setText("");
                        edtSubject.setText("");
                        edtMessage.setText("");
                        Toast.makeText(MainActivity.this,"ENVIADO",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private boolean setValidar(){
        if (edtEmail.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"ERROR: Ingrese el correo",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (edtSubject.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"ERROR: Ingrese el asunto",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (edtMessage.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"ERROR:",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

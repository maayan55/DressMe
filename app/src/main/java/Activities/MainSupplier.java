package Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dressme.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Adapters.Supplier;


public class MainSupplier extends AppCompatActivity  implements View.OnClickListener{
    private TextView displayName;
    private Button update, chat, stock, client;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_supplier);
        setViews();
    }
    private void setViews(){
        //set button
        update=(Button) findViewById(R.id.update);
        client=(Button) findViewById(R.id.customers);
        stock=(Button) findViewById(R.id.stock);

        update.setOnClickListener((View.OnClickListener) this);
        client.setOnClickListener((View.OnClickListener) this);
        stock.setOnClickListener((View.OnClickListener) this);
        //set text
        displayName = (TextView) findViewById(R.id.titel);
        //set DB ref
        firebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference().child("Suppliers").child(firebaseAuth.getUid()).child("details");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String name =snapshot.getValue(Supplier.class).getName();
                displayName.setText("Hello "+name+"! what do you want to do?");
            }
            @Override public void onCancelled(@NonNull DatabaseError error) { }
        });//end listener
    };

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.update){
            startActivity(new Intent(MainSupplier.this,update_detalis_supplier.class));
        }
        if(v.getId() == R.id.customers){
            startActivity(new Intent(MainSupplier.this,GmachCustomers.class));
        }
        if(v.getId() == R.id.stock){
            startActivity(new Intent(MainSupplier.this,GmachStockSupplier.class));
        }


    }

    //************menu bar************

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(MainSupplier.this,loginActivity.class));
    }

    public void openMain(){
        Intent intent = new Intent(this, MainSupplier.class);
        startActivity(intent);
    }

    public void openPrivateZone(){
        Intent intent = new Intent(this, update_detalis_supplier.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_logoutMenu){
            Logout();
        }
        if(item.getItemId() == R.id.personal_profile){
            openPrivateZone();
        }
        if(item.getItemId() == R.id.Home){
            openMain();
        }
        return super.onOptionsItemSelected(item);
    }
}
package inf3995_03.javachess.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import inf3995_03.javachess.controller.RestClientHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import inf3995_03.javachess.R;

import static android.R.string.no;

public class MenuPrincipal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_principal);

        final Button button = (Button) findViewById(R.id.btnId);
        button.setVisibility(View.VISIBLE);

        final Button button2 = (Button) findViewById(R.id.valider);
        final EditText player1 = (EditText) findViewById(R.id.Player1) ;
        final EditText player2 = (EditText) findViewById(R.id.Player2);
        final EditText round = (EditText) findViewById(R.id.round);
        final EditText location = (EditText) findViewById(R.id.Location);
        final EditText codeSecret = (EditText) findViewById(R.id.CodeSecret);
        final EditText temps = (EditText) findViewById(R.id.temps);
        final EditText tempsCoup = (EditText) findViewById(R.id.tempsCoup) ;
        final EditText limite = (EditText) findViewById(R.id.limit);
        final EditText tempsProlongation = (EditText) findViewById(R.id.tempsProlongation);
        final EditText tempsIncrement = (EditText) findViewById(R.id.incrementProlongation);
        final CheckBox deuxTablettes = (CheckBox) findViewById(R.id.deuxTab);
        final CheckBox enPassant = (CheckBox) findViewById(R.id.enPassant);
        final boolean tablettes;
        final boolean  option;

        final String MENUPRINCIPAL = "MENU";

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, BoardActivity.class);
                startActivity(intent);

            }
        });

        // Boutton "Valider" qui envoie le Json au serveur
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //// Pour printer a la console
                Log.d("Joueur 1", player1.getText().toString());
                Log.d("Joueur 2", player2.getText().toString());
                Log.d("Round", round.getText().toString());
                Log.d("Location", location.getText().toString());
                Log.d("CodeSecret", codeSecret.getText().toString());
                Log.d("Temps", temps.getText().toString());
                Log.d("TempsCoup", tempsCoup.getText().toString());
                Log.d("Limite", limite.getText().toString());
                Log.d("TempsProlongation", tempsProlongation.getText().toString());
                Log.d("TempsInrement", tempsIncrement.getText().toString());
                Log.d("IncrementProlongation", tempsIncrement.getText().toString());
                //Non gere pour le moment
                if(deuxTablettes.isChecked()){
                    String mode2Tab = deuxTablettes.getText().toString();
                    Log.d("mode2Tab", mode2Tab);
                }
                if(enPassant.isChecked()){
                    String optionEnpassant = enPassant.getText().toString();
                    Log.d("optionEnpassant", optionEnpassant);
                }
                //

                button.setVisibility(View.VISIBLE);

                HashMap<String, String> paramMap = new HashMap<>();

                paramMap.put("Player1",player1.getText().toString());
                paramMap.put("Player2",player2.getText().toString());
                paramMap.put("Round",round.getText().toString());
                paramMap.put("Location",location.getText().toString());
                paramMap.put("codeSecret",codeSecret.getText().toString());
                paramMap.put("Temps",temps.getText().toString());
                paramMap.put("TempsCoup",tempsCoup.getText().toString());
                paramMap.put("TempsProlongation",limite.getText().toString());
                paramMap.put("TempsIncrement",tempsProlongation.getText().toString());
                paramMap.put("IncrementProlongation",tempsIncrement.getText().toString());
                paramMap.put("TempsIncrement",tempsIncrement.getText().toString());
                paramMap.put("TempsIncrement",tempsIncrement.getText().toString());

                RequestParams params = new RequestParams(paramMap);

                //POST newGame
                RestClientHandler.post("new_game", params, new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        Log.d(MENUPRINCIPAL, String.valueOf(response));
                    }


                    @Override
                    public void onFailure(int statusCode, Header[] headers, String result, Throwable throwable) {
                        Log.d(MENUPRINCIPAL, String.valueOf(statusCode));
                        Log.d(MENUPRINCIPAL, result);
                    }

                });

            }
        });

    }

}



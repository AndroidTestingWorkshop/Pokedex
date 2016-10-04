package gojek.pokedex.add;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gojek.pokedex.R;
import gojek.pokedex.model.PokemonType;

public class AddPokemonActivity extends AppCompatActivity implements AddPokemonView {

    List<PokemonType> pokemonTypes = new ArrayList<>();
    private AddPokemonPresenter presenter;
    private EditText inputPokemonName;
    private EditText inputPokemonDescription;
    private Button buttonAdd;
    private RecyclerView listPokemonTypes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);
        buttonAdd = (Button) findViewById(R.id.button_add_pokemon);
        inputPokemonName = (EditText) findViewById(R.id.input_pokemon_name);
        inputPokemonDescription = (EditText) findViewById(R.id.input_description);
        listPokemonTypes = (RecyclerView) findViewById(R.id.list_pokemon_types);
        listPokemonTypes.setAdapter(new PokemonTypesAdapter(this));
        listPokemonTypes.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false));
        presenter = new AddPokemonPresenter(this);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokemonTypes.clear();
                String pokemonName = inputPokemonName.getText().toString();
                String description = inputPokemonDescription.getText().toString();
                presenter.addPokemonDetails(pokemonName, null, description);
            }
        });
    }

    @Override
    public void showPopupError(String errorMessage) {
        new AlertDialog.Builder(this)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setMessage(errorMessage)
                .setTitle("Alert")
                .show();
    }

    @Override
    public void showSuccessNotification() {
        Toast.makeText(this, "Pokemon has been successfully added", Toast.LENGTH_LONG).show();
    }
}

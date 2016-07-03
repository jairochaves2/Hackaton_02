package com.example.rafael.hackaton_02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    int Origem;
    int Destino;

    String ParametroOrigem;
    String ParametroDestino;

    CheckBox Paypal,Cartao,Boleto;

    //arrays de dados
    final ArrayList<String> City = Cidades();
    final ArrayList<Double> ALatitude = Latitudes();
    final ArrayList<Double> ALongitude = Long();

    //companentes
    private Spinner spnOrigem;
    private Spinner spnDestino;
    private ArrayAdapter<String> adpOrigem;
    private ArrayAdapter<String> adpDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancias Spinner
        spnOrigem = (Spinner) findViewById(R.id.spinnerOrigem);
        spnDestino = (Spinner) findViewById(R.id.spinnerDestino);

        //instancias Adapter Origem
        adpOrigem = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item);
        adpOrigem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //instancias Adapter Destino
        adpDestino = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item);
        adpDestino.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //seta  Adapters
        spnOrigem.setAdapter(adpOrigem);
        spnDestino.setAdapter(adpDestino);

        //Adiciona Cidades
        adpOrigem.addAll(Cidades());
        adpDestino.addAll(Cidades());

        //Instancias das formas de pagamento
        Paypal = (CheckBox) findViewById(R.id.checkBoxP);
        Cartao = (CheckBox) findViewById(R.id.checkBoxC);
        Boleto = (CheckBox) findViewById(R.id.checkBoxB);




    }

    public void Mapa(View view) {

        ParametroOrigem = spnOrigem.getSelectedItem().toString();
        ParametroDestino = spnDestino.getSelectedItem().toString();

        for (int i=0; i< City.size(); i++)
            if(City.get(i).equals(ParametroOrigem))
                Origem = i;
             else
                if (City.get(i).equals(ParametroDestino))
                Destino = i;

        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("Origem",ParametroOrigem);
        intent.putExtra("Destino",ParametroDestino);
        intent.putExtra("Latitude_Origem",ALatitude.get(Origem).toString());
        intent.putExtra("longitude_Origem",ALongitude.get(Origem).toString());
        intent.putExtra("Latitude_Destino",ALatitude.get(Destino).toString());
        intent.putExtra("longitude_Destino",ALongitude.get(Destino).toString());
        startActivity(intent);
    }

    public void Busca(View view) {
        String urlString = getString(R.string.searchURL) +
                Uri.encode(spnDestino.getSelectedItem().toString(), "UTF-8");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
        startActivity(webIntent);
    }

    public void Pagamento(View view){
        if(Paypal.isChecked())
            Toast.makeText(getApplicationContext(),"Forma de Pagamento Paypal",Toast.LENGTH_LONG).show();
        else
            if(Cartao.isChecked())
                Toast.makeText(getApplicationContext(),"Forma de Pagamento Cartão",Toast.LENGTH_LONG).show();
            else
                if(Boleto.isChecked())
                    Toast.makeText(getApplicationContext(),"Forma de Pagamento Boleto",Toast.LENGTH_LONG).show();

    }

    private ArrayList<Double> Latitudes(){
        ArrayList<Double> Lat = new ArrayList<Double>();
        Lat.add(-9.9753);//RioBranco
        Lat.add(-9.6498);//Maceió
        Lat.add(0.0355);//Macapá
        Lat.add(-3.1189);//Manaus
        Lat.add(-12.9722);//Salvador
        Lat.add(-3.7319);//Fortaleza
        Lat.add(-15.7941);//Brasília
        Lat.add(-20.2976);//Vitória
        Lat.add(-16.6869);//Goiânia
        Lat.add(4.137);//São Luis
        Lat.add(-15.6014);//Cuiabá
        Lat.add(-20.4697);//Campo Grande
        Lat.add(-19.9245);//Belo Horizonte
        Lat.add(-1.4558);//Belém
        Lat.add(-7.1195);//João Pessoa
        Lat.add(-25.4244);//Curitiba
        Lat.add(-8.05700);//Recife
        Lat.add(-5.092);//Teresina
        Lat.add(-22.9116);//Rio de Janeiro
        Lat.add(-5.7793);//Natal
        Lat.add(-30.0346);//Porto Alegre
        Lat.add(-9.4146);//Porto Velho
        Lat.add(2.8235);//Boa Vista
        Lat.add(-27.595);//Florianópolis
        Lat.add(-23.5505);//São Paulo
        Lat.add(-10.9472);//Aracaju
        Lat.add(-10.2491);//Palmas
        return Lat;
    }

    private ArrayList<String> Cidades() {
        ArrayList <String> Dados = new ArrayList<String>();
        Dados.add("Rio Branco");
        Dados.add("Maceió");
        Dados.add("Macapá");
        Dados.add("Manaus");
        Dados.add("Salvador");
        Dados.add("Fortaleza");
        Dados.add("Brasília");
        Dados.add("Vitória");
        Dados.add("Goiânia");
        Dados.add("São Luis");
        Dados.add("Cuiabá");
        Dados.add("Campo Grande");
        Dados.add("Belo Horizonte");
        Dados.add("Belém");
        Dados.add("João Pessoa");
        Dados.add("Curitiba");
        Dados.add("Recife");
        Dados.add("Teresina");
        Dados.add("Rio de Janeiro");
        Dados.add("Natal");
        Dados.add("Porto Alegre");
        Dados.add("Porto Velho");
        Dados.add("Boa Vista");
        Dados.add("Florianópolis");
        Dados.add("São Paulo");
        Dados.add("Aracaju");
        Dados.add("Palmas");
        return Dados;
    }

    private ArrayList<Double> Long() {
        ArrayList<Double> Lon = new ArrayList<Double>();
        Lon.add(-67.8248);
        Lon.add(-35.7089);
        Lon.add(-51.0705);
        Lon.add(-60.0215);
        Lon.add(-38.5014);
        Lon.add(-38.5267);
        Lon.add(-47.8825);
        Lon.add(-40.2957);
        Lon.add(-49.2648);
        Lon.add(-60.5383);
        Lon.add(-56.0978);
        Lon.add(-54.6201);
        Lon.add(-43.9353);
        Lon.add(-48.4902);
        Lon.add(-34.845);
        Lon.add(-49.2654);
        Lon.add(-34.8829);
        Lon.add(-42.8038);
        Lon.add(-43.1883);
        Lon.add(-35.2009);//Natal
        Lon.add(-51.2177);
        Lon.add(-64.1478);
        Lon.add(-60.6758);
        Lon.add(-48.5482);
        Lon.add(-46.6333);
        Lon.add(-37.0731);
        Lon.add(-48.3243);//Palmas
        return Lon;
    }

}

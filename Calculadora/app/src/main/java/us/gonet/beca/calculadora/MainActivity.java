package us.gonet.beca.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnSuma, btnMult,
                    btnResta, btnDiv, btnDel, btnCE, btnPunto, btnIgual;
    private TextView tvDisplay;
    private String operador="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn4= (Button) findViewById(R.id.btn4);
        btn5= (Button) findViewById(R.id.btn5);
        btn6= (Button) findViewById(R.id.btn6);
        btn7= (Button) findViewById(R.id.btn7);
        btn8= (Button) findViewById(R.id.btn8);
        btn9= (Button) findViewById(R.id.btn9);
        btn0= (Button) findViewById(R.id.btn0);
        btnPunto= (Button) findViewById(R.id.btnPunto);
        btnSuma= (Button) findViewById(R.id.btnSuma);
        btnMult= (Button) findViewById(R.id.btnMul);
        btnResta= (Button) findViewById(R.id.btnRes);
        btnDiv= (Button) findViewById(R.id.btnDiv);
        btnDel= (Button) findViewById(R.id.btnDel);
        btnCE= (Button) findViewById(R.id.btnCE);
        btnIgual= (Button) findViewById(R.id.btnIgual);
        tvDisplay= (TextView) findViewById(R.id.textView);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPunto.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
    }

    public void disableOperations(){
        btnDiv.setEnabled(false);
        btnSuma.setEnabled(false);
        btnResta.setEnabled(false);
        btnMult.setEnabled(false);
    }

    public void enableOperations(){
        btnDiv.setEnabled(true);
        btnSuma.setEnabled(true);
        btnResta.setEnabled(true);
        btnMult.setEnabled(true);
    }

    public void result(String cad){
        float num1=0, num2=0;
        for(int i=0; i < cad.length(); i++){
            if(cad.charAt(i)=='+' || cad.charAt(i)=='*' || cad.charAt(i)=='/' || cad.charAt(i)=='-') {
                num1 = Float.parseFloat(cad.substring(0, i));
                num2=  Float.parseFloat(cad.substring(i+1, cad.length()));
            }
        }
        switch(operador){
            case "+":
                tvDisplay.setText((num1+num2)+"");
                break;
            case "-":
                tvDisplay.setText((num1-num2)+"");
                break;
            case "*":
                tvDisplay.setText((num1*num2)+"");
                break;
            case "/":
                tvDisplay.setText((num1/num2)+"");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                tvDisplay.append("0");
                break;
            case R.id.btn1:
                tvDisplay.append("1");
                break;
            case R.id.btn2:
                tvDisplay.append("2");
                break;
            case R.id.btn3:
                tvDisplay.append("3");
                break;
            case R.id.btn4:
                tvDisplay.append("4");
                break;
            case R.id.btn5:
                tvDisplay.append("5");
                break;
            case R.id.btn6:
                tvDisplay.append("6");
                break;
            case R.id.btn7:
                tvDisplay.append("7");
                break;
            case R.id.btn8:
                tvDisplay.append("8");
                break;
            case R.id.btn9:
                tvDisplay.append("9");
                break;
            case R.id.btnCE:
                tvDisplay.setText("");
                enableOperations();
                break;
            case R.id.btnDel:
                String cad=tvDisplay.getText().toString();
                for(int i=0; i < cad.length(); i++){
                    if(cad.charAt(i)=='+' || cad.charAt(i)=='*' || cad.charAt(i)=='/' || cad.charAt(i)=='-') {
                        enableOperations();
                    }else{
                        disableOperations();
                    }
                }
                tvDisplay.setText(tvDisplay.getText().toString().substring(0, tvDisplay.getText().toString().length()-1));
                break;
            case R.id.btnPunto:
                tvDisplay.append(".");
                break;
            case R.id.btnSuma:
                operador="+";
                tvDisplay.append("+");
                disableOperations();
                break;
            case R.id.btnRes:
                operador="-";
                tvDisplay.append("-");
                disableOperations();
                break;
            case R.id.btnMul:
                operador="*";
                tvDisplay.append("*");
                disableOperations();
                break;
            case R.id.btnDiv:
                operador="/";
                tvDisplay.append("/");
                disableOperations();
                break;
            case R.id.btnIgual:
                if(operador.equals(""))
                    Toast.makeText(getApplicationContext(), "Ingrese valores", Toast.LENGTH_LONG).show();
                else {
                    result(tvDisplay.getText().toString());
                    enableOperations();
                }
                break;
        }
    }
}

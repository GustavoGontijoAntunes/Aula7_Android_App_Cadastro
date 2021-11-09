package com.example.aula07_appcadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.aula07_appcadastro.Util.MaskEditUtil;
import com.example.aula07_appcadastro.Util.Validation;

public class MainFragment extends Fragment {

    EditText editNome, editCpf, editEmail;
    Button btnEnviar;
    RadioButton myRadioButton;
    RadioGroup myRadioGroup;
    CheckBox myCheckbox;
    Switch mySwitch;
    Spinner mySpinner;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        editNome = view.findViewById(R.id.txtNome);
        editCpf = view.findViewById(R.id.txtCpf);
        editEmail = view.findViewById(R.id.txtEmail);
        btnEnviar = view.findViewById(R.id.btnEnviar);
        myRadioGroup = view.findViewById(R.id.idGroup);
        mySwitch = view.findViewById(R.id.switchSalvar);
        myCheckbox = view.findViewById(R.id.checkOfertas);
        mySpinner = view.findViewById(R.id.spinner);

        editCpf.addTextChangedListener(MaskEditUtil.mask(editCpf, MaskEditUtil.FORMAT_CPF));

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editNome.getText())){
                    editNome.setError("Escreva o seu nome");
                    editNome.requestFocus();
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(editEmail.getText()).matches()){
                    editEmail.setError("Insira um e-mail válido");
                    editEmail.requestFocus();
                }

                if (!Validation.validarCPF(editCpf.getText().toString())){
                    editCpf.setError("Digite um CPF válido");
                    editCpf.requestFocus();
                }

                Toast.makeText(getActivity(), "Selecionou " + mySpinner.getSelectedItem(), Toast.LENGTH_SHORT).show();

                try{
                    int rdSelectedId = myRadioGroup.getCheckedRadioButtonId();
                    myRadioButton = view.findViewById(rdSelectedId);
                    Toast.makeText(getActivity(), "Selecionou " + myRadioButton.getText().toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(getActivity(), "Selecione uma opção", Toast.LENGTH_SHORT).show();
                }

                if(myCheckbox.isChecked()){
                    Toast.makeText(getActivity(), "Checkbox marcado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Checkbox desmarcado", Toast.LENGTH_SHORT).show();
                }

                if(mySwitch.isChecked()){
                    Toast.makeText(getActivity(), "Switch ativado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Switch desativado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
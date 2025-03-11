package com.example.exercise8;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 定义UI组件
    private EditText inputFirstNumber, inputSecondNumber;
    private Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 绑定UI组件
        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        textResult = findViewById(R.id.textResult);

        // 设置加号按钮的点击事件
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        // 设置减号按钮的点击事件
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        // 设置乘号按钮的点击事件
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        // 设置除号按钮的点击事件
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    // 计算逻辑
    private void calculate(char operator) {
        try {
            // 获取输入的数字
            double num1 = Double.parseDouble(inputFirstNumber.getText().toString());
            double num2 = Double.parseDouble(inputSecondNumber.getText().toString());
            double result = 0;

            // 根据运算符执行相应的计算
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            // 显示结果
            textResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            // 处理无效输入
            Toast.makeText(this, "Please enter valid numbers!", Toast.LENGTH_SHORT).show();
        }
    }
}
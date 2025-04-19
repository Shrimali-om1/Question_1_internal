package com.example.question_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView tvTitle, tvPrice, tvDesc;
    Button btnAddToCart;

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        imgDetail = findViewById(R.id.imgDetail);
        tvTitle = findViewById(R.id.tvDetailTitle);
        tvPrice = findViewById(R.id.tvDetailPrice);
        tvDesc = findViewById(R.id.tvDetailDesc);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        productList = MainActivityDataHelper.getProducts(); // reuse data

        int index = getIntent().getIntExtra("productIndex", 0);
        Product product = productList.get(index);

        int imageRes = getResources().getIdentifier(product.imageName, "drawable", getPackageName());
        imgDetail.setImageResource(imageRes);
        tvTitle.setText(product.title);
        tvPrice.setText(product.price);
        tvDesc.setText(product.description);

        btnAddToCart.setOnClickListener(v -> {
            showToast("Added to cart");
        });

    }
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

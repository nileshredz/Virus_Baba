package com.example.virusbaba_or;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class end extends AppCompatActivity {
    Bundle intexts;
    ImageView qrc;
    String quid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        intexts = getIntent().getExtras();


        qrc = findViewById(R.id.qr);
        quid = intexts.getString("uid");


        QRGEncoder qrgEncoder = new QRGEncoder(quid, null, QRGContents.Type.TEXT, 5000);

        try {
            Bitmap qrb = qrgEncoder.encodeAsBitmap();
            qrc.setImageBitmap(qrb);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }


    public void saveImage(View view) throws IOException {
        BitmapDrawable drawable = (BitmapDrawable) qrc.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        FileOutputStream outputStream=null;

        File filepath = Environment.getExternalStorageDirectory();
        File dir = new File(filepath.getAbsolutePath() + "/VirusBaba");
        dir.mkdir();

        String filename=String.format("%d.jpg",System.currentTimeMillis());
        File outfile=new File(dir,filename);
        Toast.makeText(end.this,"QR Code is Saved Successfully",Toast.LENGTH_LONG).show();

        try{
            outputStream=new FileOutputStream(outfile);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            outputStream.flush();
            outputStream.close();

            Intent intent1=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            intent1.setData(Uri.fromFile(outfile));
            sendBroadcast(intent1);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}





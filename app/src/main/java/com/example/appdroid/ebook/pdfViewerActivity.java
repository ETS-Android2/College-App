package com.example.appdroid.ebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdroid.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.File;

public class pdfViewerActivity extends AppCompatActivity {

    private String url;
    private ProgressBar progressBar;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        url=getIntent().getStringExtra("pdfUrl");
        pdfView=findViewById(R.id.pdfView);
        progressBar=findViewById(R.id.pdfProgress);

        loadFile(url);





    }

    private void loadFile(String url) {
        FileLoader.with(this)
                .load(url)
                .fromDirectory("test4", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                        File loadedFile = response.getBody();
                        progressBar.setVisibility(View.GONE);
                        pdfView.fromFile(loadedFile)
                                .password(null)
                                .defaultPage(0)
                                .enableDoubletap(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .spacing(5)
                                .load();
                    }

                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                        Toast.makeText(pdfViewerActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }


}
package test.hjd.com.imagecompress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Drawable drawable = getResources().getDrawable(R.drawable.test);
//        new BitmapDrawable(drawable);
        /*
        如果我们直接加载8M的图片,程序就崩溃了
         */
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        String filePath = "/mnt/sdcard/" + "test_compress.jpg";
//        qualityCompress(bitmap, filePath);

//        sizeCompress(bitmap, filePath, 8);
        String filePath1 = "/mnt/sdcard/" + "test_compress1.jpg";
        sampleCompress(filePath, filePath1, 2);


    }


    public void sampleCompress(String filePath, String filePath2, int inSampleSize) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        /*
        inSampleSize设置了图片的缩小的倍数.


        https://www.2cto.com/kf/201411/353174.html
        效率高,解析速度快.
        数值只能是2的次方.不能精确指定大小.

        优点:效率较高,解析速度快
        缺点:采样率inSampleSize的取值只能是2的次方数(例如:inSampleSize=15,实际取值为8;inSampleSize=17,实际取值为16;实际取值会往2的次方结算),因此该方法不能精确的指定图片的大小
         */
        options.inSampleSize = inSampleSize;
//        options.inPreferredConfig = Bitmap.Config.RGB_565;

        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);


        File file = new File(filePath2);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        /*
        有时候调用bitmap.compress(...)之后图片会变大.
         */
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(baos.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
    大小压缩
     */
    public void sizeCompress(Bitmap bitmap, String filePath, int radio) {

        Bitmap resultBitmap = Bitmap.createBitmap(bitmap.getWidth() / radio, bitmap.getHeight() / radio, Bitmap.Config.ARGB_8888);
        Rect rect = new Rect(0, 0, bitmap.getWidth() / radio, bitmap.getHeight() / radio);
        Canvas canvas = new Canvas(resultBitmap);

        canvas.drawBitmap(bitmap, null, rect, null);


        File file = new File(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        /*
        有时候调用bitmap.compress(...)之后图片会变大.
         */
        resultBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(baos.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    质量压缩
     */
    public void qualityCompress(Bitmap bitmap, String filePath) {

        File file = new File(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        /*
        有时候调用bitmap.compress(...)之后图片会变大.
         */
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(baos.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

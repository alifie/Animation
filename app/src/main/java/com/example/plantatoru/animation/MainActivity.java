package com.example.plantatoru.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private Button startTweenAnimation;
    private Button startFrameAnimation;


    private ImageView tweenAnimation;
    private ImageView frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //helper method that sets up the views
        initializeViews();

        startFrameAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //helper method that ensure the animated view can be seen
                ensureVisibility(frameAnimation);

                //sets the background resource of the blank image view for the frame animation
                //to the resource that represents the animation.
                frameAnimation.setBackgroundResource(R.drawable.loading_animation);

                //extracts and AnimationDrawable from the image view.
                AnimationDrawable frameAnimationDrawable = (AnimationDrawable) frameAnimation.getBackground();

                // Starts the animation
                frameAnimationDrawable.start();
            }
        });

        startTweenAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //helper method to ensure that the view we are animating can be seen.
                ensureVisibility(tweenAnimation);

                //builds the rotate animation from the XML resource "R.anim.rotate"
                Animation rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);

                //begin the rotate animation
                tweenAnimation.startAnimation(rotate);


            }
        });


    }

    /*
    * helper method that initializes the views. Much of the boilerplate code is
    * encapsulated here.
    * */
    private void initializeViews() {

        this.startFrameAnimation = (Button) findViewById(R.id.button_frame);
        this.startTweenAnimation = (Button) findViewById(R.id.button_tween);

        this.tweenAnimation = (ImageView) findViewById(R.id.tween);
        this.frameAnimation = (ImageView) findViewById(R.id.frame);
     }

    /*
    * Since we're sharing the middle of the screen with 2 views, this method will make sure
    * that the one you want to use is visible whereas the other is hidden.
    *
    * @param image The image who's visibility you want to showcase
    */
    private void ensureVisibility(ImageView image) {

        if(image==tweenAnimation){

            frameAnimation.setVisibility(View.GONE);
            tweenAnimation.setVisibility(View.VISIBLE);
        }
        else if(image==frameAnimation){

            tweenAnimation.setVisibility(View.GONE);
            frameAnimation.setVisibility(View.VISIBLE);

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
}

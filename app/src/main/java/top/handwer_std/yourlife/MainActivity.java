package top.handwer_std.yourlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch swcWork;
    private Switch swcSocial;
    private Switch swcGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swcGame = (Switch) findViewById(R.id.switchGame);
        swcSocial = (Switch) findViewById(R.id.switchSocial);
        swcWork = (Switch) findViewById(R.id.switchWork);
    }

    public int CheckStatus() {
        int ret = 0;
        if (swcSocial.isChecked()) ++ret;
        if (swcWork.isChecked()) ++ret;
        if (swcGame.isChecked()) ++ret;
        return ret;
    }
    public void Open() { swcWork.setChecked(true); }
    public void oncWork(View view) {
        int Status = CheckStatus();
        if (swcWork.isChecked()) {
            // if swcWork is on, swcGame will be closed preferentially
            if (Status == 3) {
                // All turned on, close swcGame
                swcGame.setChecked(false);
            }
        } else {
            // if there isn't any checked switch, turn swcWork on
            if (Status == 0) Open();
        }
    }
    public void oncSoci(View view) {
        int Status = CheckStatus();
        if (swcSocial.isChecked()) {
            // if swcSocial is on, swcWork will be closed preferentially
            if (Status == 3) {
                swcWork.setChecked(false);
            }
        } else {
            if (Status == 0) Open();
        }
    }
    public void oncGame(View view) {
        int Status = CheckStatus();
        if (swcGame.isChecked()) {
            // if swcGame is on, swcSocial will be closed preferentially
            if (Status == 3) {
                swcSocial.setChecked(false);
            }
        } else {
            if (Status == 0) Open();
        }
    }
}

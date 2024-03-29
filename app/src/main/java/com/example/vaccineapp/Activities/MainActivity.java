package com.example.vaccineapp.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vaccineapp.model_kotlin.Appointment;
import com.example.vaccineapp.model_kotlin.Profile;
import com.example.vaccineapp.model_kotlin.InfoElement;
import com.example.vaccineapp.model.ProfilesManager;
import com.example.vaccineapp.R;
import com.example.vaccineapp.model_kotlin.Service;
import com.example.vaccineapp.model_kotlin.TimelineStage;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(itemSelect);

        //TRY TO DINAMICALLY RESIZE PHOTOS WITHOUT MAKING SEVERAL XML'S
        LinearLayout rootView = (LinearLayout) findViewById(R.id.main_root_view);
        Log.d("PRUEBA", "Altura total: " + rootView.getMeasuredWidth());

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Log.d("PRUEBA", "Ancho total: " + width);
        Log.d("PRUEBA", "Altura total: " + height);
        ImageView imgVaccine = (ImageView) findViewById(R.id.img_vaccine);
        ImageView imgHealth = (ImageView) findViewById(R.id.img_health);
        imgVaccine.getLayoutParams().width = width/4;
        imgVaccine.requestLayout();
        imgHealth.getLayoutParams().width = width/4;
        imgVaccine.requestLayout();
        if (ProfilesManager.profiles.size() == 0) {
            Log.d("PRUEBA", "ENTRA A PONER LOS PERFILES");
            Calendar cal1 = Calendar.getInstance();
            cal1.set(1985, 3, 14);
            Profile profile1 = new Profile("Juan Carlos", Color.RED, cal1, 26, 1);
            profile1.addInformation("Pre-pregnant");
            profile1.addInformation("Blood type 0+");
            profile1.setImage(R.drawable.doctoricon);
            ProfilesManager.profiles.add(profile1);

            Calendar cal2 = Calendar.getInstance();
            cal2.set(1983, 11, 7);
            Profile profile2 = new Profile("Hatty Hattington", Color.BLUE, cal2, 36, 2);
            profile2.addInformation("First child");
            profile2.addInformation("Blood type 0+");
            profile2.setImage(R.drawable.ambulanceicon);
            ProfilesManager.profiles.add(profile2);

            Calendar cal3 = Calendar.getInstance();
            cal3.set(1994, 8, 24);
            Profile profile3 = new Profile("Test", Color.GREEN, cal3, 25, 0);
            profile3.addInformation("Second child");
            profile3.addInformation("Blood type 0-");
            profile3.setImage(R.drawable.calendar_icon);
            ProfilesManager.profiles.add(profile3);

            /* -------------------------------------------------------- */

            /* -------------------------------------------------------- */

            TimelineStage stage11 = new TimelineStage();
            stage11.addInfoElement(new InfoElement("At Birth", 1));
            stage11.addInfoElement(new InfoElement("HepB", 1));
            ProfilesManager.profiles.get(0).addTimelineStage(stage11);

            TimelineStage stage12 = new TimelineStage();
            stage12.addInfoElement(new InfoElement("1-2 Months", 1));
            stage12.addInfoElement(new InfoElement("HelpB", 1));
            ProfilesManager.profiles.get(0).addTimelineStage(stage12);

            TimelineStage stage13 = new TimelineStage();
            stage13.addInfoElement(new InfoElement("2 Months", 1));
            stage13.addInfoElement(new InfoElement("DtaP: Diphtheria, Tetanus, acellualr pertussis", 1));
            stage13.addInfoElement(new InfoElement("Hib: Haemophilus influenza type B", 1));
            ProfilesManager.profiles.get(0).addTimelineStage(stage13);

            TimelineStage stage14 = new TimelineStage();
            stage14.addInfoElement(new InfoElement("4 Months", -2));
            stage14.addInfoElement(new InfoElement("HepB", -2));
            ProfilesManager.profiles.get(0).addTimelineStage(stage14);

            ArrayList<Service> servicios = new ArrayList<>();
            servicios.add(new Service("Vaccine", 0));
            ProfilesManager.profiles.get(0).addAppointment(new Appointment("Periodic health check", "Tic Hospital", "Dr. Heatlh Raider", LocalDateTime.now(), servicios));
            ProfilesManager.profiles.get(0).addAppointment(new Appointment("Test", "12 de octubre", "Dr. Zoidberg", LocalDateTime.now(), servicios));
            LocalDateTime date = new LocalDateTime(2019,4,10,5,5);
            ProfilesManager.profiles.get(1).addAppointment(new Appointment("Stuffy stuff", "Some hospital", "Some doctor", date, servicios));

            /* ----------------------------------------------------------*/

            TimelineStage stage21 = new TimelineStage();
            stage21.addInfoElement(new InfoElement("At Birth", 1));
            stage21.addInfoElement(new InfoElement("HepB", 1));
            ProfilesManager.profiles.get(1).addTimelineStage(stage21);

            TimelineStage stage22 = new TimelineStage();
            stage22.addInfoElement(new InfoElement("1-2 Months", 1));
            stage22.addInfoElement(new InfoElement("HelpB", 1));
            ProfilesManager.profiles.get(1).addTimelineStage(stage22);

            TimelineStage stage23 = new TimelineStage();
            stage23.addInfoElement(new InfoElement("2 Months", -1));
            stage23.addInfoElement(new InfoElement("DtaP: Diphtheria, Tetanus, acellualr pertussis", 1));
            stage23.addInfoElement(new InfoElement("Hib: Haemophilus influenza type B", 1));
            stage23.addInfoElement(new InfoElement("IPV: inactivated pollovirus", -2));
            stage23.addInfoElement(new InfoElement("PCV: Pneumoccal conjugate", -2));
            stage23.addInfoElement(new InfoElement("RV: Rotavirus", -2));
            ProfilesManager.profiles.get(1).addTimelineStage(stage23);

            /* ---------------------------------------------------------------*/

            TimelineStage stage31 = new TimelineStage();
            stage31.addInfoElement(new InfoElement("At Birth", 1));
            stage31.addInfoElement(new InfoElement("HepB", 1));
            ProfilesManager.profiles.get(2).addTimelineStage(stage31);

            TimelineStage stage32 = new TimelineStage();
            stage32.addInfoElement(new InfoElement("1-2 Months", 1));
            stage32.addInfoElement(new InfoElement("HelpB", 1));
            ProfilesManager.profiles.get(2).addTimelineStage(stage32);

            TimelineStage stage33 = new TimelineStage();
            stage33.addInfoElement(new InfoElement("2 Months", -1));
            stage33.addInfoElement(new InfoElement("DtaP: Diphtheria, Tetanus, acellualr pertussis", 1));
            stage33.addInfoElement(new InfoElement("Hib: Haemophilus influenza type B", 1));
            stage33.addInfoElement(new InfoElement("IPV: inactivated pollovirus", -2));
            stage33.addInfoElement(new InfoElement("PCV: Pneumoccal conjugate", -2));
            stage33.addInfoElement(new InfoElement("RV: Rotavirus", -2));
            ProfilesManager.profiles.get(2).addTimelineStage(stage33);

            TimelineStage stage34 = new TimelineStage();
            stage34.addInfoElement(new InfoElement("4 Months", 1));
            stage34.addInfoElement(new InfoElement("HepB", 1));
            ProfilesManager.profiles.get(2).addTimelineStage(stage34);

            TimelineStage stage35 = new TimelineStage();
            stage35.addInfoElement(new InfoElement("8 Months", -1));
            stage35.addInfoElement(new InfoElement("HepB", -1));
            ProfilesManager.profiles.get(2).addTimelineStage(stage35);
        }
        Log.d("PRUEBA", "Y al final del oncreate hay " + ProfilesManager.profiles.size() + " perfiles");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener itemSelect = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
                    //intent = new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                    break;
                case R.id.nav_profile:
                    //Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_LONG).show();
                    intent = new Intent(getApplicationContext(), SignInActivity.class);
                    startActivity(intent);
                    break;
                case R.id.nav_settings:
                    Toast.makeText(getApplicationContext(), "Setting", Toast.LENGTH_LONG).show();
                    break;
            }
            return false;
        }
    };

    public void changeToFindVaccine(View v) {
        Toast.makeText(getApplicationContext(), "Change to 'Find Vaccine' screen", Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
    }

    public void changeToHealthStates(View v) {
        Toast.makeText(getApplicationContext(), "Change to 'Health States' screen", Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
    }

    public void changeToAppointment(View v) {
        Toast.makeText(getApplicationContext(), "Change to 'AppointmentsActivity' screen", Toast.LENGTH_LONG).show();
        intent = new Intent(this, AppointmentsActivity.class);
        startActivity(intent);
    }

    public void changeToScheduler(View v) {
        Toast.makeText(getApplicationContext(), "Change to 'Scheduler' screen", Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
    }


    public void changeToFindDoctors(View v) {
        Toast.makeText(getApplicationContext(), "Change to 'Find Doctors' screen", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void changeToFindHospitals(View v) {
        Toast.makeText(getApplicationContext(), "Change to 'Hospitals' screen", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ProfilesListActivity.class);
        startActivity(intent);
    }

}
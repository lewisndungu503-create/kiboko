package com.example.kiboko_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {
//    create interstitial variable to hold interstitial ads
    private var mInterstitialAd: InterstitialAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        initialize ADMOB ADS
        MobileAds.initialize(this)


        val adView=findViewById<AdView>(R.id.adview)
        val adRequest= AdRequest.Builder().build()
//        show add
        adView.loadAd(adRequest)
//        Load Interstitial ad
        loadInterstitialAd()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val checkProgress=findViewById<Button>(R.id.check_progress)
        val dailyMotivation=findViewById<Button>(R.id.daily_motivation)
        val startExercise=findViewById<Button>(R.id.start_exercise)
        val weeklyGoals=findViewById<Button>(R.id.weekly_goals)
        val meditation=findViewById<Button>(R.id.meditation)
        val nutritionalAdvice=findViewById<Button>(R.id.nutrition_advice)
        val hydrationAlert=findViewById<Button>(R.id.hydration_alert)
        val healthyRecipes=findViewById<Button>(R.id.healthy_tips)

        checkProgress.setOnClickListener {
            val intent= Intent(applicationContext, Check_Progress::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
        dailyMotivation.setOnClickListener {
            val intent= Intent(applicationContext, Daily_Motivation::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
        startExercise.setOnClickListener {
            val intent= Intent(applicationContext, Start_Exercise::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
        weeklyGoals.setOnClickListener {
            val intent= Intent(applicationContext, Weekly_Goals::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
        meditation.setOnClickListener {
            val intent= Intent(applicationContext, Meditation::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
        nutritionalAdvice.setOnClickListener {
            val intent= Intent(applicationContext, Nutritional_Advice::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
        hydrationAlert.setOnClickListener {
            val intent= Intent(applicationContext, Hydration_Alert::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
        healthyRecipes.setOnClickListener {
            val intent= Intent(applicationContext, Healthy_Recipes::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
    }
//    load the interstitial ad
fun loadInterstitialAd(){
//    request ad frm admos
    val adRequest= AdRequest.Builder().build()
    InterstitialAd.load(
        this,
        "ca-app-pub-3940256099942544/1033173712",
        adRequest,
        object : InterstitialAdLoadCallback(){
//            load something on ad
            override fun onAdLoaded(ad: InterstitialAd) {
                mInterstitialAd=ad
            }
//            set variable to null if ad fails to load
            override fun onAdFailedToLoad(error: LoadAdError) {
                mInterstitialAd=null
            }
        }
    )
}
//    show ad
fun showInterstitialAd(){
    if(mInterstitialAd!=null){
        mInterstitialAd?.show(this)
    }
}
}
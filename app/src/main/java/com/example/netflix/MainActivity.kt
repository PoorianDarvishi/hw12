package com.example.netflix

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.netflix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            val bottomNavigationView = bottomNavigationView
            bottomNavigationView.setupWithNavController(navController)


            bottomNavigationView.setOnItemSelectedListener{menuItem ->
                when(menuItem.itemId){
                    R.id.item_home -> {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<HomeFragment>(R.id.fragmentContainerView)
                        }
                    }
                    R.id.item_like -> {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<LikeFragment>(R.id.fragmentContainerView)
                        }
                    }
                    R.id.item_coming_soon -> {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<ComingSoonFragment>(R.id.fragmentContainerView)
                        }
                    }
                    R.id.item_profile -> {
                        if(mainViewModel.checkRegister()){
                            supportFragmentManager.commit {
                                setReorderingAllowed(true)
                                replace<ProfileFragment>(R.id.fragmentContainerView)
                            }
                        }else{
                            supportFragmentManager.commit {
                                setReorderingAllowed(true)
                                replace<RegisterFragment>(R.id.fragmentContainerView)
                            }
                        }

                    }
                }
                true
            }
        }
    }
}
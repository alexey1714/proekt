package com.example.proga


import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import com.example.proga.databinding.ActivityMainBinding

class MainActivity : BaseActivity(), INavMainActivity {
    lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]
        goToMessageFrag()
        binding.bottomNavMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.message -> {
                    goToMessageFrag()

                }
                R.id.people -> {
                    goToPeopleFrag()

                }
                R.id.group -> {
                    goToGroupFrag()

                }
                R.id.setting -> {
                    goToSettingFrag()
                }
            }
            true
        }
    }



    override fun goToMessageFrag() {
        replaceFragment(R.id.frameLayout, MessageFragment.newInstance())
        binding.mainTb.title = getString(R.string.message)
        binding.mainTb.visibility = View.VISIBLE

    }

    override fun goToPeopleFrag() {
        replaceFragment(R.id.frameLayout, PeopleFragment.newInstance())
        binding.mainTb.title = getString(R.string.people)
        binding.mainTb.visibility = View.VISIBLE
    }

    override fun goToGroupFrag() {
        replaceFragment(R.id.frameLayout, GroupFragment.newInstance())
        binding.mainTb.title = getString(R.string.group)
        binding.mainTb.visibility = View.VISIBLE
    }

    override fun goToSettingFrag() {
        replaceFragment(R.id.frameLayout, SettingFragment.newInstance())
        binding.mainTb.visibility = View.GONE
    }
}

interface INavMainActivity {
    fun goToMessageFrag()
    fun goToPeopleFrag()
    fun goToGroupFrag()
    fun goToSettingFrag()
}
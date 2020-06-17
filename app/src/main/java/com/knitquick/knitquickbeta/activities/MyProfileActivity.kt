package com.knitquick.knitquickbeta.activities

import android.os.Bundle
import com.bumptech.glide.Glide
import com.knitquick.knitquickbeta.R
import com.knitquick.knitquickbeta.model.User
import kotlinx.android.synthetic.main.activity_my_profile.*

// TODO (Step 1: Create a MyProfileActivity class.)
// START
class MyProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        // TODO (Step 8: Call a function to setup action bar.)
        setupActionBar()
    }

    // TODO (Step 7: Create a function to setup action bar.)
    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_my_profile_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.my_profile)
        }

        toolbar_my_profile_activity.setNavigationOnClickListener { onBackPressed() }
    }
    // TODO (Step 2: Create a function to set the existing data in UI.)
    // START
    /**
     * A function to set the existing details in UI.
     */
    fun setUserDataInUI(user: User) {
        Glide
            .with(this@MyProfileActivity)
            .load(user.image)
            .centerCrop()
            .placeholder(R.drawable.ic_user_place_holder)
            .into(iv_user_image)

        et_name.setText(user.name)
        et_email.setText(user.email)
        if (user.mobile != 0L) {
            et_mobile.setText(user.mobile.toString())
        }
    }
    // END
}
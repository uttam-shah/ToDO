package com.example.todo.login_reg

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todo.R
import com.example.todo.databinding.FragmentSignup2Binding
import com.example.todo.login_reg.view_models.SignupViewModel
import com.github.dhaval2404.imagepicker.ImagePicker

class Signup2Fragment : Fragment() {

    private lateinit var viewModel: SignupViewModel
    private lateinit var binding: FragmentSignup2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signup2, container, false
        )

        viewModel = ViewModelProvider(requireActivity()).get(SignupViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Set click listener for the ImageView to open the image picker
        binding.imgAdd.setOnClickListener {
            Toast.makeText(context, "Clicked to add image", Toast.LENGTH_SHORT).show()
            openImagePicker()
        }

        return binding.root
    }

    private fun openImagePicker() {
        ImagePicker.with(this)
            .crop()	    			// Crop image (Optional)
            .compress(1024)			// Final image size will be less than 1 MB (Optional)
            .maxResultSize(1080, 1080)	// Final image resolution will be less than 1080 x 1080 (Optional)
            .start()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!

            // Use Uri object instead of File to avoid storage permissions
            binding.imgUser.setImageURI(uri)
            viewModel.setImageUri(uri)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            //Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            //Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}

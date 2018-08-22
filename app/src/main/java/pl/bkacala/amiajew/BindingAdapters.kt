package pl.bkacala.amiajew

import android.databinding.BindingAdapter
import android.support.design.widget.TextInputLayout
import android.widget.ImageView

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageViewResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

    @JvmStatic
    @BindingAdapter("text_input_layout:error")
    fun setImageViewResource(textInputLayout: TextInputLayout, error: String) {
        textInputLayout.error = error
    }
}

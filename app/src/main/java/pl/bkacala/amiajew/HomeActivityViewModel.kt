package pl.bkacala.amiajew

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.annotation.DrawableRes

class HomeActivityViewModel : BaseObservable() {

    @Bindable
    var enableCheckButton: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.enableCheckButton)
        }

    @Bindable
    var errorText: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.errorText)
        }

    @Bindable
    @DrawableRes
    var image: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.image)
        }
}

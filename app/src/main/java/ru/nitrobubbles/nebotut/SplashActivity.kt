package ru.nitrobubbles.nebotut
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.facebook.rebound.Spring
import com.facebook.rebound.SpringConfig
import com.facebook.rebound.SpringListener
import com.facebook.rebound.SpringSystem
import kotlinx.android.synthetic.main.splash_activity.*
import java.util.*

/**
 * Created by konstantinaksenov on 02.03.16.
 */
class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        val splashImages : IntArray = intArrayOf(R.drawable.image_1, R.drawable.image_2)
        tiltView.setImageResource(splashImages[Random().nextInt(splashImages.size)])
        var springSystem = SpringSystem.create()
        var spring = springSystem.createSpring()
        spring.springConfig = SpringConfig(60.0, 3.0)
        spring.setCurrentValue(0.0 , true)
        spring.addListener(object : SpringListener{
            override fun onSpringEndStateChange(p0: Spring?) {
            }

            override fun onSpringActivate(p0: Spring?) {
            }

            override fun onSpringAtRest(p0: Spring?) = startActivity(Intent(baseContext, MainActivity::class.java))

            override fun onSpringUpdate(spring: Spring?) {
                val scaleValue : Double = spring?.currentValue as Double
                logoView.scaleX = scaleValue.toFloat()
                logoView.scaleY = scaleValue.toFloat()
            }
        })
        spring.endValue = 1.0


    }
}

package paixao.lueny.curso_android_kotlin.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Entity
@Parcelize
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val description: String,
    val value: BigDecimal,
    val image: String? = null,
    val userId: String? = null
) : Parcelable {



  // Utilizado apenas para testes
    @Ignore
    val valorValido = !valorMenorOuIgualAZero() && !valorMaiorQueCem()

    private fun valorMenorOuIgualAZero(): Boolean {
        return value <= BigDecimal.ZERO

    }
    private fun valorMaiorQueCem(): Boolean {
        return value > BigDecimal(100)
    }
}


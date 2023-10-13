import androidx.room.Entity
import androidx.room.PrimaryKey
import io.realm.kotlin.types.RealmObject

class Product : RealmObject {
    var productId: Long = 0  // Use Long for auto-generated primary key
    var name: String = ""
    var description: String = ""
    var picture: String = ""
    var owner: ApplicationUser = ApplicationUser()

}

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import org.mongodb.kbson.ObjectId


class ApplicationUser() : RealmObject {
    @PrimaryKey
    private var _id: ObjectId = ObjectId()
    val username: String = ""
    val email: String  = ""
    val password: String = ""
    val favoriteProducts: RealmList<Product> = realmListOf()

}
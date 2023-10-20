package com.project.beertracker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.project.beertracker.data.local.dao.ApplicationUserDao
import com.project.beertracker.data.local.dao.ConsumptionDao
import com.project.beertracker.data.local.dao.ProductDao
import com.project.beertracker.data.local.dao.ProductReviewDao
import com.project.beertracker.domain.model.ApplicationUser
import com.project.beertracker.domain.model.Consumption
import com.project.beertracker.data.local.entities.ProductEntity
import com.project.beertracker.domain.model.ProductReview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [ApplicationUser::class, Consumption::class, ProductEntity::class, ProductReview::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun applicationUserDao(): ApplicationUserDao
    abstract fun consumptionDao(): ConsumptionDao
    abstract fun productDao(): ProductDao
    abstract fun productReviewDao(): ProductReviewDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        private class RoomDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        var productDao = database.productDao()

                        // Delete all content here.
                        productDao.deleteAllProducts()

                        // Add sample words.
                        var product = ProductEntity("123", "111", "test1", "test2", "picture1",false, "TEST")
                        productDao.upsertProduct(product)
                        product = ProductEntity("123", "111", "test1", "test2", "picture5", false, "TEST")
                        productDao.upsertProduct(product)

                        // TODO: Add your own words!
                        product = ProductEntity("128", "111", "test1", "test2", "picture2",false, "TEST")
                        productDao.upsertProduct(product)
                    }
                }
            }
        }

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "social_drink"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}
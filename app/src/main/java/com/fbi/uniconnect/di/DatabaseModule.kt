package com.fbi.uniconnect.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.fbi.uniconnect.core.database.AdminDao
import com.fbi.uniconnect.core.database.AcademicSyncMetadataDao
import com.fbi.uniconnect.core.database.AnnouncementDao
import com.fbi.uniconnect.core.database.AssignmentDao
import com.fbi.uniconnect.core.database.AttendanceDao
import com.fbi.uniconnect.core.database.GradeDao
import com.fbi.uniconnect.core.database.KrsDao
import com.fbi.uniconnect.core.database.LecturerDao
import com.fbi.uniconnect.core.database.ScheduleDao
import com.fbi.uniconnect.core.database.StudentDao
import com.fbi.uniconnect.core.database.UniConnectDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DATABASE_NAME = "uniconnect.db"

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                """
                CREATE TABLE IF NOT EXISTS academic_sync_metadata (
                    id TEXT NOT NULL,
                    lastAttemptAtEpochMillis INTEGER NOT NULL,
                    lastSuccessfulAtEpochMillis INTEGER,
                    PRIMARY KEY(id)
                )
                """.trimIndent(),
            )
        }
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): UniConnectDatabase = Room.databaseBuilder(
        context,
        UniConnectDatabase::class.java,
        DATABASE_NAME,
    ).addMigrations(MIGRATION_1_2).build()

    @Provides fun provideStudentDao(db: UniConnectDatabase): StudentDao = db.studentDao()
    @Provides fun provideLecturerDao(db: UniConnectDatabase): LecturerDao = db.lecturerDao()
    @Provides fun provideAdminDao(db: UniConnectDatabase): AdminDao = db.adminDao()
    @Provides fun provideScheduleDao(db: UniConnectDatabase): ScheduleDao = db.scheduleDao()
    @Provides fun provideAttendanceDao(db: UniConnectDatabase): AttendanceDao = db.attendanceDao()
    @Provides fun provideGradeDao(db: UniConnectDatabase): GradeDao = db.gradeDao()
    @Provides fun provideKrsDao(db: UniConnectDatabase): KrsDao = db.krsDao()
    @Provides fun provideAssignmentDao(db: UniConnectDatabase): AssignmentDao = db.assignmentDao()
    @Provides fun provideAnnouncementDao(db: UniConnectDatabase): AnnouncementDao = db.announcementDao()
    @Provides fun provideAcademicSyncMetadataDao(db: UniConnectDatabase): AcademicSyncMetadataDao =
        db.academicSyncMetadataDao()
}

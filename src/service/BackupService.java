package service;

import dao.BackupDao;
import entity.Backup;
import java.util.Date;

/**
 * Created by Ding on 17/1/1.
 */
public class BackupService {
    BackupDao dao = new BackupDao();
    public boolean addBackup(String name, String descriptor, int autho) {
        if(autho != 0 || autho != 1) {
            return false;
        }
        Backup newBackup = new Backup();
        newBackup.setBackupName(name);

        newBackup.setpurchaseDate(new Date());
        newBackup.setIsBroken(false);
        return dao.saveAddBackup(newBackup);
    }
    public boolean brokeBackup(String backupId, int autho) {
        if(autho != 0 || autho != 1) {
            return false;
        }
        Date brokeDate = new Date();
        return dao.saveBrokenBackup(brokeDate, backupId);
    }
    public boolean borrowBackup(String eId, String backupName) {
        Date borrowDate = new Date();
        return dao.saveBorrowBackup(eId, borrowDate, backupName);
    }
    public boolean returnBackup(String backupId) {
        Date returnDate = new Date();
        return dao.saveReturnBackup(returnDate, backupId);
    }
}

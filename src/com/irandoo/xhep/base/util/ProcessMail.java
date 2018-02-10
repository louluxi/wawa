package com.irandoo.xhep.base.util;



public class ProcessMail implements Runnable {

    public void run() {
        
        Mail mail = null;
        while (true) {
            try {
                synchronized (MailQuene.getInstance().getMailQuene()) {
                    mail = MailQuene.getInstance().getMailQuene().take();
                    MailSend.getInstance().sendMail(mail.getMailAddress(), mail.getName(), mail.getContent(),
                        mail.getFilesPath());
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            catch (Error e) {
                e.printStackTrace();
            }

        }

    }

}

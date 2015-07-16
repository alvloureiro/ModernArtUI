package labs.course.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by loureiro on 7/16/15.
 */
public class MoreInformationDialogFragment extends DialogFragment {
    private static final String MOMA_URL = "http://www.moma.org";

    public static MoreInformationDialogFragment newInstance () {
        MoreInformationDialogFragment fragment = new MoreInformationDialogFragment();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.action_visit_moma,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Uri uri = Uri.parse(MOMA_URL);
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                                    startActivity(intent);
                                }
                            }
                        })
                .setCancelable(false)
                .setNegativeButton(R.string.action_not_now,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dismiss();
                            }
                        })
                .create();
    }
}

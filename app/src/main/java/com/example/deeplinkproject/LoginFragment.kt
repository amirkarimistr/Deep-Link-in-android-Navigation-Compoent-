package com.example.deeplinkproject

import android.app.PendingIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class LoginFragment : Fragment() {
    private var btnLogin: Button ?= null
    private var btnShowNotification: Button ?= null

    private val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        btnLogin = view.findViewById(R.id.btn_login)
        btnShowNotification = view.findViewById(R.id.btn_notification)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin?.text = args.name
        btnLogin?.setOnClickListener {
            findNavController().popBackStack()
        }

        btnShowNotification?.setOnClickListener {
            val pendingIntent =
                findNavController()
                        .createDeepLink().
                            setGraph(R.navigation.nav_graph)
                                .setDestination(R.id.loginFragment)
                                    .setArguments(LoginFragmentArgs("by test ")
                                        .toBundle()).createPendingIntent()


            showNotification(pendingIntent, "amir ")


        }
    }

    private fun showNotification(pendingIntent: PendingIntent, receivedName: String) {

        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            notification.setSmallIcon(R.drawable.ic_image)
            notification.setContentTitle("Notification ")
            notification.setContentIntent(pendingIntent)
            notification.setContentText("Hello world ! ")


        NotificationManagerCompat.from(requireContext()).notify(1022, notification.build())



    }


}
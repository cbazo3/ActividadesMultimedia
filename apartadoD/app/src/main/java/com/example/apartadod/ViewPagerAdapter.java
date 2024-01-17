package com.example.apartadod;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final Fragment[] fragments; // Un arreglo de fragmentos
    private final String[] fragmentTitles; // Opcional: títulos de las páginas

    public ViewPagerAdapter(FragmentManager fm, Fragment[] fragments, String[] fragmentTitles) {
        super(fm);
        this.fragments = fragments;
        this.fragmentTitles = fragmentTitles;
    }

    @Override
    public Fragment getItem(int position) {
        // Devuelve el fragmento que corresponde a la posición
        return fragments[position];
    }

    @Override
    public int getCount() {
        // Devuelve el número total de páginas
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Opcional: Devuelve el título de la página en la posición
        if (fragmentTitles != null && position < fragmentTitles.length) {
            return fragmentTitles[position];
        }
        return super.getPageTitle(position);
    }
}